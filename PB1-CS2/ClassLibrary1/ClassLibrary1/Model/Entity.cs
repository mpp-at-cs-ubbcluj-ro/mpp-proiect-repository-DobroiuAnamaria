namespace ClassLibrary1.Model
{
    public class Entity<CId>
    {
        
        private CId? _id;

        protected CId? Id
        {
            get => _id;
            set => _id = value;
        }
    }
}