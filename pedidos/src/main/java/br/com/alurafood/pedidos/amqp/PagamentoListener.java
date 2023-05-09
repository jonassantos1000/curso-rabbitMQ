package br.com.alurafood.pedidos.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.alurafood.pedidos.dto.PagamentoDto;

@Component
public class PagamentoListener {

	@RabbitListener(queues = "pagamentos.detalhes-pedido")
	public void recebeMensagem(@Payload PagamentoDto pagamento) {
        String mensagem = """
                Pagamento pedido: %s 
                Id do pagamento: %s
                Nome do cliente: %s
                Valor R$: %s
                Status: %s 
                """.formatted(pagamento.getPedidoId(),
                pagamento.getId(),
                pagamento.getNome(),
                pagamento.getValor(),
                pagamento.getStatus());

        System.out.println(mensagem);
	}
}
