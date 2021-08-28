using System;
using Xunit;
using System.Collections.Generic;
using System.Collections;

namespace SampleLibrary.Test
{
    public class PreProcessTest
    {
        [Fact]
        public void Test1()
        {
            ArrayList _orQuery, _andQuery,_ExQuery;
            PreProcess preProcess = new PreProcess();
            const string query = "word1 +word2 -word3 +word4 -word5 word6";
            preProcess.ProcessQuery(query);
            _orQuery = preProcess.GetOrQueries();
            _andQuery = preProcess.GetAndQueries();
            _ExQuery = preProcess.GetExQueries();
            Assert.True(_orQuery.Contains("+word2"));
            Assert.True(_orQuery.Contains("+word4"));
            Assert.Equal(2, _orQuery.Count);
            Assert.True(_andQuery.Contains("+word1"));
            Assert.True(_andQuery.Contains("+word6"));
            Assert.Equal(2, _andQuery.Count);
            Assert.True(_ExQuery.Contains("+word3"));
            Assert.True(_ExQuery.Contains("+word5"));
            Assert.Equal(2, _ExQuery.Count);
        }
    }
}