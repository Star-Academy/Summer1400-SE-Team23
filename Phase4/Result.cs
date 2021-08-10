using System;

namespace studentsProject
{
    public class Result
    {
        public Student Student { get; set; }
        public double Average { get; set; }
        
        public Result(Student student, double average)
        {
            this.Student = student;
            this.Average = average;
        }
    }
}