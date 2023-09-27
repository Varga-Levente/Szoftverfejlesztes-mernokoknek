#!/bin/bash

# Mérjük az időt a script futásának kezdetén
start=$(date +"%s")

# SSH kapcsolat létesítése a távoli szerverrel, majd a script futtatása a távoli gépen
ssh -p ${SERVER_PORT} ${SERVER_USER}@${SERVER_HOST} -i key.txt -t -t -o StrictHostKeyChecking=no << 'ENDSSH'

# Docker container letöltése
docker pull vlevente2001/sfm-react:latest

# Docker konténer nevének beállítása.
CONTAINER_NAME=sfm-react-app

# Ellenőrizzük, hogy van-e futó konténer ezen a néven.
if [ "$(docker ps -qa -f name=$CONTAINER_NAME)" ]; then
    # Ha van futó konténer, akkor leállítjuk.
    if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
        echo "Container is running -> stopping it..."
        docker stop $CONTAINER_NAME;
    fi
fi

# Docker konténer indítása a megadott beállításokkal.
docker run -d --rm -p 80:80 --name $CONTAINER_NAME vlevente2001/sfm-react:latest

# Kilépés a távoli szerverről.
exit
ENDSSH

# Ellenőrizzük a távoli végrehajtás visszatérési értékét.
if [ $? -eq 0 ]; then
  # Sikeres végrehajtás esetén a script is sikeresen lefutott.
  exit 0
else
  # Hiba esetén a script hibával tér vissza.
  exit 1
fi

# Mérjük az időt a script futásának végén.
end=$(date +"%s")

# Számítsuk ki, mennyi időbe telt a script futása.
diff=$(($end - $start))

# Kiírjuk a futási időt.
echo "Deployed in : ${diff}s"