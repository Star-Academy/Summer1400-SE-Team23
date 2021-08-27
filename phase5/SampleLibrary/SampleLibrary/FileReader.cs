using System.Collections.Generic;
using System.IO;
using System.Net.Http;
using System.Text;

namespace SampleLibrary
{
    public class FileReader
    {
        public Dictionary<string, string> GetDocumentsContent()
        {
            var documentsContent = new Dictionary<string, string>();
            foreach (var txtName in Directory.EnumerateFileSystemEntries(@"resources/EnglishData"))
            {
                var name = Path.GetFileName(txtName);
                var content = "";
                var lines = File.ReadAllLines(txtName);
                foreach (var line in lines)
                {
                    content = content + line + " ";
                }
                documentsContent.Add(name, content);
                
            }

            return documentsContent;
        }
        
        
    }
}