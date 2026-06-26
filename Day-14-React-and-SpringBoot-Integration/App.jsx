import { useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [dname, setDname] = useState("");
  const [dspec, setDspec] = useState("");
  const [dage, setDage] = useState("");
  const [dsalary, setDsalary] = useState("");
  const [HId, setHId] = useState("");

  async function sendData(event) {
    event.preventDefault();

    const doctor = {
      doctorName: dname,
      doctorSpeciality: dspec,
      doctorAge: parseInt(dage),
      doctorSalary: parseInt(dsalary),
      hospitalId: parseInt(HId)
    };

    try {
      const response = await axios.post(
        "http://localhost:8082/doctor/create",
        doctor
      );

      alert(response.data);
      console.log(response.data);
    } catch (error) {
      console.log(error);

      if (error.response) {
        console.log(error.response.data);
        alert(JSON.stringify(error.response.data));
      } else {
        alert("Unable to connect to Spring Boot server.");
      }
    }
  }

  return (
    <div>
      <form onSubmit={sendData}>

        <label>Enter Doctor Name:</label><br />
        <input
          type="text"
          value={dname}
          onChange={(e) => setDname(e.target.value)}
        />
        <br /><br />

        <label>Enter Doctor Specialization:</label><br />
        <input
          type="text"
          value={dspec}
          onChange={(e) => setDspec(e.target.value)}
        />
        <br /><br />

        <label>Enter Doctor Age:</label><br />
        <input
          type="number"
          value={dage}
          onChange={(e) => setDage(e.target.value)}
        />
        <br /><br />

        <label>Enter Doctor Salary:</label><br />
        <input
          type="number"
          value={dsalary}
          onChange={(e) => setDsalary(e.target.value)}
        />
        <br /><br />

        <label>Enter Hospital Id:</label><br />
        <input
          type="number"
          value={HId}
          onChange={(e) => setHId(e.target.value)}
        />
        <br /><br />

        <button type="submit">Submit</button>

      </form>
    </div>
  );
}

export default App;