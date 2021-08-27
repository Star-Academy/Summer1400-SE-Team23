using System;
using Xunit;
using System.Collections.Generic;
using System.Collections;


namespace SampleLibrary.Test
{
    public class InitializerTest
    {
        [Fact]
        public void Test1()
        {
            Dictionary<string, string> documentsContent = new Dictionary<string, string>();
            documentsContent.Add("Doc1", "salam salam khoobi ya na?");
            documentsContent.Add("Doc2", "salam chetori ya na?");
            Initializer init = new Initializer();
            init.Initialize(documentsContent);
            Dictionary<String, ArrayList> result = init.GetDictionary();
            ArrayList salam = result["salam"];
            ArrayList khoobi = result["khoobi"];
            ArrayList ya = result["ya"];
            ArrayList na = result["na?"];
            ArrayList chetori = result["chetori"];
            Assert.Equal(2,salam.Count);
            Assert.Equal(1,khoobi.Count);
            Assert.Equal(2,ya.Count);
            Assert.Equal(2,na.Count);
            Assert.Equal(1,chetori.Count);
            Assert.True(salam.Contains("Doc1"));
            Assert.True(salam.Contains("Doc2"));
            Assert.True(khoobi.Contains("Doc1"));
            Assert.True(ya.Contains("Doc1"));
            Assert.True(ya.Contains("Doc2"));
            Assert.True(na.Contains("Doc1"));
            Assert.True(na.Contains("Doc2"));
            Assert.True(chetori.Contains("Doc2"));
        }
    }
}
