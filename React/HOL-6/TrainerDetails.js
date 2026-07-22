import { useParams } from "react-router-dom";
import trainers from "./TrainersMock";

function TrainerDetail() {
  const { id } = useParams();

  const trainer = trainers.find(
    (trainer) => trainer.trainerId === Number(id)
  );

  if (!trainer) {
    return <h2>Trainer not found</h2>;
  }

  return (
    <div>
      <h1>Trainer Details</h1>

      <p>Trainer ID: {trainer.trainerId}</p>
      <p>Name: {trainer.name}</p>
      <p>Email: {trainer.email}</p>
      <p>Phone: {trainer.phone}</p>
      <p>Technology: {trainer.technology}</p>
      <p>Skills: {trainer.skills}</p>
    </div>
  );
}

export default TrainerDetail;