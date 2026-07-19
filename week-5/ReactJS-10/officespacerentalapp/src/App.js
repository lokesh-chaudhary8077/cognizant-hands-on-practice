import './App.css';
import officeImg from './office.jpg';

function App() {

  const office = {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai"
  };

  const officeList = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai"
    },
    {
      Name: "Regus",
      Rent: 75000,
      Address: "Bangalore"
    },
    {
      Name: "SmartWorks",
      Rent: 65000,
      Address: "Hyderabad"
    }
  ];

  return (
    <div className="App">

      <h1>Office Space Rental App</h1>

      <img
        src={officeImg}
        alt="Office Space"
        width="500"
        height="300"
      />

      <h2>Featured Office</h2>

      <p><b>Name:</b> {office.Name}</p>

      <p style={{ color: office.Rent < 60000 ? "red" : "green" }}>
        <b>Rent:</b> Rs. {office.Rent}
      </p>

      <p><b>Address:</b> {office.Address}</p>

      <hr />

      <h2>Available Office Spaces</h2>

      {
        officeList.map((item, index) => (

          <div key={index} className="card">

            <h3>{item.Name}</h3>

            <p
              style={{
                color: item.Rent < 60000 ? "red" : "green"
              }}
            >
              <b>Rent:</b> Rs. {item.Rent}
            </p>

            <p>
              <b>Address:</b> {item.Address}
            </p>

          </div>

        ))
      }

    </div>
  );
}

export default App;