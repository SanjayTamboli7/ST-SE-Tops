function Item({ name, isPacked }) {
    return (
      <li className="item">
        {name} {isPacked && '✔'}
      </li>
    );
  }
  
  export default function PackingList() {
    return (
      <section>
        <h4>Sally Ride's Packing List</h4>
        <ul>
          <Item
            isPacked={true}
            name="Space suit"
          />
          <Item
            isPacked={true}
            name="Helmet with a golden leaf"
          />
          <Item
            isPacked={false}
            name="Photo of Tam"
          />
        </ul>
      </section>
    );
  }
  