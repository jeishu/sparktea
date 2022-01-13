import Topbar from "../../components/topbar/Topbar";
import Feed from "../../components/feed/Feed";
import "./home.scss"

export default function Home() {
  return (
    <>
      <Topbar />
      <div className="homeContainer">
        <Feed/>
      </div>
    </>
  );
}
