import Post from "../post/Post";
import Share from "../share/Share";
import "./feed.scss";

export default function Feed() {
  return (
    <div className="feed">
      <div className="feedWrapper">
        <Share />
        <Post/>
      </div>
    </div>
  );
}
