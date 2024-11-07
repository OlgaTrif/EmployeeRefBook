package model.writer;

import java.io.Serializable;

public interface ReferenceBookWriteable {
    boolean write(Serializable serializable, String filePath);
}
