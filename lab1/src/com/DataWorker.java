package com;

import com.dto.Data;
import com.exception.WrongFileDataFormat;

public interface DataWorker {
    Data readData() throws Exception;
}
