using System.Collections;

namespace SampleLibrary
{
    public class PreProcess
    {
        private ArrayList _orQueries = new ArrayList();
        private ArrayList _andQueries = new ArrayList();
        private ArrayList _exQueries = new ArrayList();

        public void ProcessQuery(string query)
        {
            if(_orQueries.Count > 0)
                _orQueries.Clear();
            if(_andQueries.Count > 0)
                _andQueries.Clear();
            if(_exQueries.Count > 0)
                _exQueries.Clear();
            var words = query.Split("\\s");
            foreach (var word in words)
            {
                if (word.StartsWith("+"))
                {
                    _orQueries.Add(word);
                }
                else if (word.StartsWith("-"))
                {
                    _exQueries.Add(word);
                }
                else
                {
                    _andQueries.Add(word);
                }
            }
        }

        public ArrayList GetAndQueries()
        {
            return _andQueries;
        }
        public ArrayList GetOrQueries()
        {
            return _orQueries;
            
        }
        public ArrayList GetExQueries()
        {
            return _exQueries;
        }
    }
}