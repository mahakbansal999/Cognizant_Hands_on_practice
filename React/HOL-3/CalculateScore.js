import React from "react";

function CalculateScore(props) {
  const average = (props.total / props.goal) * 100;

  return (
    <div>
      <h1>Student Score Calculator</h1>
      <p>Name: {props.name}</p>
      <p>School: {props.school}</p>
      <p>Total Score: {props.total}</p>
      <p>Goal: {props.goal}</p>
      <p>Average Score: {average.toFixed(2)}%</p>
    </div>
  );
}

export default CalculateScore;