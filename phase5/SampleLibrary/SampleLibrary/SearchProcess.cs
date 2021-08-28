using System;
using System.Collections;
using System.Collections.Generic;

namespace SampleLibrary
{
    public class SearchProcess
    {
        public ArrayList MiddleProcess(ArrayList orQueries, ArrayList andQueries, ArrayList exQueries,
            Dictionary<string, ArrayList> dictionary)
        {
            ArrayList result = new ArrayList();
            foreach (string word in orQueries)
            {
                if (!dictionary.ContainsKey(word.Substring(1)))
                {
                    continue;
                }

                foreach (string doc in dictionary[word.Substring(1)])
                {
                    if (!result.Contains(doc))
                        result.Add(doc);
                }
            }

            if (result.Count == 0)
            {
                foreach (string word in andQueries)
                {
                    if (dictionary.ContainsKey(word))
                    {
                        foreach (string doc in dictionary[word.Substring(1)])
                        {
                            if (!result.Contains(doc))
                            {
                                result.Add(doc);
                            }
                        }
                        break;
                    }
                }
            }

            foreach (string word in andQueries)
            {
                if (!dictionary.ContainsKey(word))
                {
                    result.Clear();
                    break;
                }

                foreach (string doc in result)
                {
                    if (!dictionary[word.Substring(1)].Contains(doc))
                    {
                        result.Remove(doc);
                    }
                }
            }
            foreach(string word in exQueries){
                if(!dictionary.ContainsKey(word.Substring(1)))
                    continue;
                foreach(string document in dictionary[word.Substring(1)]){
                    result.Remove(document);
                }
            }
            return result;
        }
    }
}