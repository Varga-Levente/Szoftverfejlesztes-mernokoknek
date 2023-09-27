import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHamburger, faUser } from '@fortawesome/free-solid-svg-icons'; 
import './VerticalMenu.css';

const VerticalMenu = () => {

    const handleListItemHover = (event) => {
        // Az összes a li elemen belüli elem kiválasztása
        const elementsInsideListItem = event.currentTarget.querySelectorAll('*');
    
        // Az összes a li elemen belüli elem színének beállítása
        elementsInsideListItem.forEach((element) => {
          element.style.color = '#F74346'; // Változtasd meg a színt az igényeid szerint
        });
      };
    
      // Eseményfigyelő a listitem hover hatásának megszűnésekor
      const handleListItemLeave = (event) => {
        // Az összes a li elemen belüli elem színének visszaállítása eredeti színre
        event.currentTarget.querySelectorAll('*').forEach((element) => {
          element.style.color = ''; // Üres string a szín visszaállításához
        });
    };

  return (
    <ul className="nav flex-column">
        <li
            className="nav-item listitem active"
            onMouseEnter={handleListItemHover}
            onMouseLeave={handleListItemLeave}
        >
            <a className="nav-link active navigationlink" href="/#">
                <i className="material-icons mui">movie</i><br />
                <span className="menuname">Billboard</span>
            </a>
        </li>
        <li className="nav-item listitem"
            onMouseEnter={handleListItemHover}
            onMouseLeave={handleListItemLeave}
        >
            <a className="nav-link navigationlink" href="/#">
                <i className="material-icons mui">movie_filter</i><br />
                <span className="menuname">Coming soon</span>
            </a>
        </li>
        <li className="nav-item listitem"
            onMouseEnter={handleListItemHover}
            onMouseLeave={handleListItemLeave}
        >
            <a className="nav-link navigationlink" href="/#">
                <FontAwesomeIcon icon={faHamburger} className="fas faicon" /><br />
                <span className="menuname">Food</span>
            </a>
        </li>
        <li className="nav-item listitem" style={{ paddingBottom: 15 }}
            onMouseEnter={handleListItemHover}
            onMouseLeave={handleListItemLeave}
        >
            <a className="nav-link navigationlink" href="/#">
                <FontAwesomeIcon icon={faUser} className="fas faicon" /><br />
                <span className="menuname">Profile</span>
            </a>
        </li>
    </ul>
  );
}

export default VerticalMenu;