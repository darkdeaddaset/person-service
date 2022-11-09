package ru.savin.personservice.core.service.rabbit;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.config.rabbit.Types;

@Service
@AllArgsConstructor
public class MessageListener {
    @RabbitListener(queues = Types.DAILY)
    public void queueDaily(String message){
        System.out.println(String.format("Получено сообщение [%s] из очереди [%s]", message, Types.DAILY));
    }

    @RabbitListener(queues = Types.ALERT)
    public void queueAlert(String message){
        System.out.println(String.format("Получено сообщение [%s] из очереди [%s]", message, Types.ALERT));
    }
}
