import { Link } from "react-router-dom";

function TrainersList({ trainers }) {
  return (
    <div>
      <h1>Trainers List</h1>

      <ul>
        {trainers.map((trainer) => (
          <li key={trainer.trainerId}>
            <Link to={`/trainers/${trainer.trainerId}`}>
              {trainer.name}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TrainersList;