using System;
using Xunit;
using System.Collections.Generic;
using System.Collections;


namespace SampleLibrary.Test
{
    public class SearchProcessTest
    {
        private ArrayList _orQueries;
        private ArrayList _andQueries;
        private ArrayList _exQueries;
        private Dictionary<string, ArrayList> _dictionary;

        [Fact]
        public void SearchTest(){
            _orQueries = new ArrayList();
            _andQueries = new ArrayList();
            _exQueries = new ArrayList();
            _dictionary = new Dictionary<string, ArrayList>();


            _orQueries.Add("+google");
            _orQueries.Add("+facebook");

            _andQueries.Add("samsung");
            _andQueries.Add("apple");


            _exQueries.Add("-map");

            ArrayList tmp = new ArrayList();
            tmp.Add("Doc1");
            tmp.Add("Doc2");
            tmp.Add("Doc3");
            _dictionary.Add("google",tmp);
            ArrayList tmp1 = new ArrayList();
            tmp1.Add("Doc4");
            tmp1.Add("Doc2");
            tmp1.Add("Doc3");
            _dictionary.Add("facebook",tmp1);
            ArrayList tmp2 = new ArrayList();
            ArrayList tmp3 = new ArrayList();
            ArrayList tmp4 = new ArrayList();
            tmp2.Add("Doc4");
            tmp2.Add("Doc2");
            tmp2.Add("Doc1");
            tmp2.Add("Doc5");
            _dictionary.Add("samsung",tmp2);
            tmp3.Add("Doc4");
            tmp3.Add("Doc2");
            tmp3.Add("Doc1");
            tmp3.Add("Doc6");
            _dictionary.Add("apple",tmp3);
            tmp4.Add("Doc1");
            tmp4.Add("Doc6");
            _dictionary.Add("map",tmp4);
            SearchProcess searchProcess = new SearchProcess();
            ArrayList test = searchProcess.MiddleProcess(_orQueries,_andQueries,_exQueries,_dictionary);
            Assert.True(test.Contains("Doc2")); 
            Assert.True(test.Contains("Doc4"));
            Assert.Equal(2,test.Count);
        }
    }
}