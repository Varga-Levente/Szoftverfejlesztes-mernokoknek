# Modifications
- Created /DB endpoint to display all users in the H2 database (FILE)

---

# To add new data to the HashMap use this code in browser console:
```js
(async function createPerson() {

    let demo = {
        "name": "John Doe",
        "age": "30",
        "birthPlace": "New York",
        "birthDate": "2000-01-01"
    };

    await fetch('http://localhost:8080/person', {
        method: "POST",
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(demo)
    })
    .then(result => result.text())
    .then(text => alert(text));
})();
```

# To delete data from the HashMap by id use this code in browser console:
```js
(async function deletePhoto(id) {
          await fetch("http://localhost:8080/person/" + id, {
                    method: "DELETE"
          })
})("ID_HERE");
```