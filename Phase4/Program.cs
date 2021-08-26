using System;
using System.Collections.Generic;
using System.Linq;

namespace studentsProject
{
    class Program
    {
        static void Main(string[] args)
        {
            var fileReader = new FileReader();
            var averageCalculator = new AverageCalculator();
            var topThree = (averageCalculator.Calculate(fileReader.DeserializeReadJson<Student>("Students"), fileReader.DeserializeReadJson<Grade>("Scores"))).Take(3);
            foreach (var bestStudent in topThree)
            {
                Console.WriteLine("name: " + bestStudent.Student.FirstName + " " + bestStudent.Student.LastName + " Score: " + bestStudent.Average);
            }
            
        }
    }
}
