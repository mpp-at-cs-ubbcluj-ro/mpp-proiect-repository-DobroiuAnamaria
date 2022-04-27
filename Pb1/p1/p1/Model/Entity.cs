namespace p1.Model
{
    public class Entity<CId>
    {
        
        private CId? _id;

        public CId? Id
        {
            get => _id;
            set => _id = value;
        }
    }
}