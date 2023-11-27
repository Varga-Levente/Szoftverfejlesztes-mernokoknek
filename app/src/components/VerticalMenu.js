import React from 'react';
import { useLocation } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHamburger, faUser } from '@fortawesome/free-solid-svg-icons';
import './VerticalMenu.css';

const VerticalMenu = () => {
    const location = useLocation();

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
            <a className={`nav-link navigationlink ${location.pathname === '/' ? 'active' : ''}`} href="/#">
                <i className="material-icons mui">movie</i><br />
                <span className="menuname">Billboard</span>
            </a>
        </li>
        <li className="nav-item listitem"
            onMouseEnter={handleListItemHover}
            onMouseLeave={handleListItemLeave}
        >
            <a className={`nav-link navigationlink ${location.pathname === '/coming-soon' ? 'active' : ''}`} href="/coming-soon">
                <i className="material-icons mui">movie_filter</i><br />
                <span className="menuname">Coming soon</span>
            </a>
        </li>
        <li className="nav-item listitem"
            onMouseEnter={handleListItemHover}
            onMouseLeave={handleListItemLeave}
        >
            <a className={`nav-link navigationlink ${location.pathname === '/food' ? 'active' : ''}`} href="/food">
                <FontAwesomeIcon icon={faHamburger} className="fas faicon" /><br />
                <span className="menuname">Food</span>
            </a>
        </li>
        <li className="nav-item listitem" style={{ paddingBottom: 15 }}
            onMouseEnter={handleListItemHover}
            onMouseLeave={handleListItemLeave}
        >
            <a className={`nav-link navigationlink ${["/profile", "/settings"].includes(location.pathname) ? 'active' : ''}`} href="/profile">
                <FontAwesomeIcon icon={faUser} className="fas faicon" /><br />
                <span className="menuname">Profile</span>
            </a>
        </li>
    </ul>
  );
}

export default VerticalMenu;