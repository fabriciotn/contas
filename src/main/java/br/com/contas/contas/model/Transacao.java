package br.com.contas.contas.model;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.OffsetDateTimeAsStringAttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.time.OffsetDateTime;

@Data
@Builder
@DynamoDbBean
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    @Getter(onMethod_={@DynamoDbAttribute("id"), @DynamoDbPartitionKey})
    String id;

    @Getter(onMethod_={@DynamoDbAttribute("sort"), @DynamoDbSortKey})
    String sort;

    String categoria;

    String categoriaDescricao;

    String contaCorrente;

    @Getter(onMethod_ = {@DynamoDbConvertedBy(OffsetDateTimeAsStringAttributeConverter.class)})
    OffsetDateTime dataPagamento;

    String descricao;

    Boolean ehRecorrente;

    FormaPagamentoEnum formaPagamento;

    StatusEnum status;

    TipoTransacao tipo;

    Double valor;
}
