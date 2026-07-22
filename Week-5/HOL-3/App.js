import React from "react";
import CalculateScore from "./Components/CalculateScore";
import "./Stylesheets/mystyle.css";

function App() {
  return (
    <CalculateScore
      name="Mahak"
      school="GLA University"
      total={850}
      goal={1000}
    />
  );
}

export default App;
