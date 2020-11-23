package service.Impl;

import service.Service;

@org.springframework.stereotype.Service
public class ApplicationServiceImpl implements Service {
    @Override
    public int calculate(int num) {
        return num*23000;
    }
}
