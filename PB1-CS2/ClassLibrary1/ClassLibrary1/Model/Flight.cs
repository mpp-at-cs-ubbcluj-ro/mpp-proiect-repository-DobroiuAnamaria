namespace ClassLibrary1.Model
{
    public class Flight : Entity<int>
    {
        private string _destination;
        private string _arrival;
        private string _dateDeparture;
        private string _timeDeparture;
        private string _airport;
        int _numberOfplace;

        public Flight(string destination, string arrival, string dateDeparture, string timeDeparture, string airport, int numberOfplace)
        {
            _destination = destination;
            _arrival = arrival;
            _dateDeparture = dateDeparture;
            _timeDeparture = timeDeparture;
            _airport = airport;
            _numberOfplace = numberOfplace;
        }
        
        public string Destination
        {
            get => _destination;
            set => _destination = value;
        }
        
        public string Arrival
        {
            get => _arrival;
            set => _arrival = value;
        }
        
        public string DateDeparture
        {
            get => _dateDeparture;
            set => _dateDeparture = value;
        }
        
        public string TimeDeparture
        {
            get => _timeDeparture;
            set => _timeDeparture = value;
        }
        
        public string Airport
        {
            get => _airport;
            set => _airport = value;
        }
        
        public int NumberOfPlace
        {
            get => _numberOfplace;
            set => _numberOfplace = value;
        }
    }
}