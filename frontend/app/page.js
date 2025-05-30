import Image from "next/image";
import styles from "./page.module.css";

export default function Home() {
  return (
    <div>
      <h1>hi. home page!</h1>
      <a href={'/create-post'}>click here to create post</a>
    </div>
  );
}
