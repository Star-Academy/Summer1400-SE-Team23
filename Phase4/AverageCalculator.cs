using System;
using System.Collections.Generic;
using System.Linq;

namespace studentsProject
{
    public class AverageCalculator
    {
        public IEnumerable<Result> Calculate(IEnumerable<Student> students, IEnumerable<Grade> scores)
        {
            var AverageList = students.GroupJoin(scores, st => st.StudentNumber, sc => sc.StudentNumber, (st, sc) => new Result (st, sc.Select(s => s.Score).Average())).OrderByDescending(s => s.Average);
            return AverageList;
        }
    }
}