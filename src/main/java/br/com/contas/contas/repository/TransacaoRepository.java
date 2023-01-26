package br.com.contas.contas.repository;

import br.com.contas.contas.model.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class TransacaoRepository {

    @Value("${TABLE_NAME}")
    private String tableName;

    @Autowired
    private DynamoDbEnhancedClient dynamoDbenhancedClient ;

    public void save(final Transacao transacao) {
        DynamoDbTable<Transacao> transacaoTable = getTable();
        transacaoTable.putItem(transacao);
    }

    private DynamoDbTable<Transacao> getTable() {
        DynamoDbTable<Transacao> table =
                dynamoDbenhancedClient.table(tableName,
                        TableSchema.fromBean(Transacao.class));
        return table;
    }
}
