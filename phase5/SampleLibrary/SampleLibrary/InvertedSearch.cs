using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;

namespace SampleLibrary
{
    public class InvertedSearch
    {
        private string Query { get; set; }
        public void Run()
        {
            FileReader fileReader = new FileReader();
            Dictionary<string, string> hash = fileReader.GetDocumentsContent();
            Initializer init = new Initializer();
            init.Initialize(hash);
            Dictionary<string, ArrayList> dictionary = init.GetDictionary();
            
            SearchEngine searchEngine = new SearchEngine(dictionary);
            ArrayList result = searchEngine.Search(Query);
            foreach (var document in result)
            {
                Console.Write(document + " ");
            }
            Console.Write("\n");
        }
    }
}
