export default function TodoList() {
  
  const today = new Date();

  function formatDate(date) {
    return new Intl.DateTimeFormat(
      'en-US',
      { weekday: 'long' }
    ).format(date);
  }
  
    return (
      <div>
        <h1>Hedy Lamarr's Todos on {formatDate(today)}</h1>
        <img 
          src="https://i.imgur.com/yXOvdOSs.jpg" 
          alt="Hedy Lamarr" 
          className="photo" 
        />
        <ul>
          <li>Invent new traffic lights</li>
          <li>Rehearse a movie scene</li>
          <li>Improve the spectrum technology</li>
        </ul>
      </div>
    );
  }
  