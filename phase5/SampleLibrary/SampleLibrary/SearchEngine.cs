using System.Collections;
using System.Collections.Generic;
using Microsoft.VisualBasic;

namespace SampleLibrary
{
    public class SearchEngine
    {
        private Dictionary<string, ArrayList> _dictionary;
        private ArrayList orQueries;
        private ArrayList andQueries;
        private ArrayList exQueries;

        public SearchEngine(Dictionary<string, ArrayList> dictionary)
        {
            orQueries = new ArrayList();
            andQueries = new ArrayList();
            exQueries = new ArrayList();
            this._dictionary = dictionary;
        }

        public ArrayList Search(string query)
        {
            ArrayList result = new ArrayList();
            PreProcess preProcess = new PreProcess();
            preProcess.ProcessQuery(query.ToLower());
            orQueries = preProcess.GetOrQueries();
            andQueries = preProcess.GetAndQueries();
            exQueries = preProcess.GetExQueries();
            SearchProcess searchProcess = new SearchProcess();
            result = searchProcess.MiddleProcess(orQueries, andQueries, exQueries, _dictionary);
            return result;
        }
    }
    
}