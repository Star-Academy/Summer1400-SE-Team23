using System.Collections;
using System.Collections.Generic;

namespace SampleLibrary
{
    public class Initializer
    {
        private Dictionary<string, ArrayList> _dictionary;

        public void Initialize(Dictionary<string, string> documentsContent)
        {
            _dictionary = new Dictionary<string, ArrayList>();
            foreach (var item in documentsContent)
            {
                string document = item.Key;
                string[] words = item.Value.Split(" ");
                foreach (var word in words)
                {
                    ArrayList documentsSet;
                    if (_dictionary.ContainsKey(word))
                    {
                        documentsSet = _dictionary[word];
                    }
                    else
                    {
                        documentsSet = new ArrayList();
                    }

                    if (documentsSet.LastIndexOf(document) == -1)
                        documentsSet.Add(document);
                    if (_dictionary.ContainsKey(word))
                    {
                        _dictionary[word] = documentsSet;
                    }
                    else
                    {
                        _dictionary.Add(word, documentsSet);
                    }
                }
                
            }
            
        }

        public Dictionary<string, ArrayList> GetDictionary()
        {
            return _dictionary;
        }
    }
}