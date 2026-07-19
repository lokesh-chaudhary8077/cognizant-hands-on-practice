import React from "react";
import "./App.css";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {

  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;

  return (
    <div className="container">

      {showCourses && <CourseDetails />}

      {showBooks && <BookDetails />}

      {showBlogs && <BlogDetails />}

    </div>
  );
}

export default App;