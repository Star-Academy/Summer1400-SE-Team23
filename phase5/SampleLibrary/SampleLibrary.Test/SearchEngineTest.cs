using System;
using Xunit;
using System.Collections.Generic;
using System.Collections;



namespace SampleLibrary.Test
{
    public class SearchEngineTest
    {
        [Fact]
        public void MixedQueryTest1()
        {
            Dictionary<string, ArrayList> dictionary = new Dictionary<string, ArrayList>();
            dictionary.Add("word1", new ArrayList(){"1","2","3"});
            dictionary.Add("word2", new ArrayList(){"1","2","4"});
            dictionary.Add("word3", new ArrayList(){"5"});
            dictionary.Add("word4", new ArrayList(){"4","5"});
            dictionary.Add("word5", new ArrayList(){"2","3"});
            SearchEngine searchEngine = new SearchEngine(dictionary);
            string query = "word1 word2 -word4";
            ArrayList result = searchEngine.Search(query);
            Assert.True(result.Contains("1"));
            Assert.True(result.Contains("2"));
            Assert.Equal(2, result.Count);
        }
        
        [Fact]
        public void MixedQueryTest2()
        {
            Dictionary<string, ArrayList> dictionary = new Dictionary<string, ArrayList>();
            dictionary.Add("word1", new ArrayList(){"1","2","3"});
            dictionary.Add("word2", new ArrayList(){"1","2","4"});
            dictionary.Add("word3", new ArrayList(){"5"});
            dictionary.Add("word4", new ArrayList(){"4","5"});
            dictionary.Add("word5", new ArrayList(){"2","3"});
            SearchEngine searchEngine = new SearchEngine(dictionary);
            string query = "+word3 +word4 -word5";
            ArrayList result = searchEngine.Search(query);
            Assert.True(result.Contains("4"));
            Assert.True(result.Contains("5"));
            Assert.Equal(2, result.Count);
        }
    }
}