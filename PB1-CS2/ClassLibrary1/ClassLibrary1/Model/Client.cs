namespace ClassLibrary1.Model
{
    public class Client  : Entity<int>
    {
        private string _firstNameC;
        private string _firstNameT;
        private string _lastNameC;
        private string _lastNameT;
        private string _address;
        private int _numberOfPlaces;

        public Client(string address, int numberOfPlaces, string lastNameT, string lastNameC, string firstNameT, string firstNameC)
        {
            _lastNameT = lastNameT;
            _lastNameC = lastNameC;
            _firstNameT = firstNameT;
            _firstNameC = firstNameC;
            _address = address;
            _numberOfPlaces = numberOfPlaces;
            
        }

        public string FirstNameC
        {
            get => _firstNameC;
            set => _firstNameC = value;
        }
        
        public string LastNameC
        {
            get => _lastNameC;
            set => _lastNameC = value;
        }
        
        public string FirstNameT
        {
            get => _firstNameT;
            set => _firstNameT = value;
        }
        
        public string LastNameT
        {
            get => _lastNameT;
            set => _lastNameT = value;
        }
    
        public string Address
        {
            get => _address;
            set => _address = value;
        }
        
        public int NumberOfPlace
        {
            get => _numberOfPlaces;
            set => _numberOfPlaces = value;
        }
        
        public override string ToString()
        {
            return Id + "Client " + _firstNameC + " " + _lastNameC + "Tourist " + _firstNameT + " " + _lastNameT + "Address " + _address + "| Number of places" + _numberOfPlaces;
        }
    }
}