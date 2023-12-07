import { people } from './data.js';
import { getImageUrl } from './Utils.js';
import './list.css'

export default function List() {
  const listItems = people.map(person =>
    <li key={person.id}>
      <img
        src={getImageUrl(person)}
        alt={person.name}
      />
      <p>
        <b>{person.name}:</b>
        {' ' + person.profession + ' '}
        known for {person.accomplishment}
      </p>
    </li>
  );

  return (
    <article>
      <h4>Scientists</h4>
      <ul>{listItems}</ul>
    </article>
  );
}
