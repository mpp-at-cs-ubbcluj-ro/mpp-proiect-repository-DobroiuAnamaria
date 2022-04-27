namespace p1.Model
{
    public class Client  : Entity<int>
    {
    private string _username;
    private string _password;
    private string _NameClient;
    private string _address;

        public Client(string username,string password,string NameClient,
            string address)
        {
            _username = username;
            _password = password;
            _NameClient = NameClient;
            _address = address;
                
        }

        public string NameClient
        {
            get => _NameClient;
            set => _NameClient = value;
        }
        
        public string Username
        {
            get => _username;
            set => _username = value;
        }
        
        public string Password
        {
            get => _password;
            set => _password = value;
        }
        
   
        public string Address
        {
            get => _address;
            set => _address = value;
        }
        
       
        
        public override string ToString()
        {
            return Id + "Client " + _username+ " " + _password + "Client name " + _NameClient + " " + "Address " + _address ;
        }
    }
}