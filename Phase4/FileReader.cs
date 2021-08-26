using System;
using System.IO;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace studentsProject
{
    class FileReader{
        public List<T> DeserializeReadJson<T>(String fileName){
            var jsoncontent = File.ReadAllText("Resources/"+fileName+".json");
            return JsonConvert.DeserializeObject<List<T>>(jsoncontent);
        }
    }
    
}
