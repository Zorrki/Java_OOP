import java.util.List;

public class StreamService {
    private List<Stream> streams;

    public StreamService(List<Stream> streams) {
        this.streams = streams;
    }

    public void sortStreamsByGroupCount() {
        streams.sort(new StreamComparator());
    }

    public List<Stream> getStreams() {
        return streams;
    }
}