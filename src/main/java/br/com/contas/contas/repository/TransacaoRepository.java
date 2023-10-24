package br.com.contas.contas.repository;

import br.com.contas.contas.model.Transacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

@Repository
@Slf4j
public class TransacaoRepository {

    public static final String TRANSACAO = "TRANSACAO";
    @Value("${TABLE_NAME}")
    private String tableName;

    @Autowired
    private DynamoDbEnhancedClient dynamoDbenhancedClient ;

    private DynamoDbTable<Transacao> getTable() {
        DynamoDbTable<Transacao> table =
                dynamoDbenhancedClient.table(tableName,
                        TableSchema.fromBean(Transacao.class));
        return table;
    }

    public Transacao save(final Transacao transacao) {
        DynamoDbTable<Transacao> transacaoTable = getTable();
        transacaoTable.putItem(transacao);
        return transacao;
    }

    public Transacao findByID(final String id) {
        DynamoDbTable<Transacao> transacaoTable = getTable();
        return transacaoTable.getItem(Key.builder()
                .partitionValue(id)
                .sortValue(TRANSACAO)
                .build());
    }

    public List<Transacao> findAll() {
        DynamoDbTable<Transacao> transacaoTable = getTable();


        // 1. Define a QueryConditional instance to return items matching a partition value.
        //QueryConditional keyEqual = QueryConditional.keyEqualTo(b -> b.partitionValue("movie01"));
        // 1a. Define a QueryConditional that adds a sort key criteria to the partition value criteria.
        //QueryConditional sortGreaterThanOrEqualTo = QueryConditional.sortGreaterThanOrEqualTo(b -> b.partitionValue("movie01").sortValue("actor2"));
        // 2. Define a filter expression that filters out items whose attribute value is null.
        //final Expression filterOutNoActingschoolname = Expression.builder().expression("attribute_exists(actingschoolname)").build();


        QueryConditional sortGreaterThanOrEqualTo = QueryConditional.sortGreaterThanOrEqualTo(b -> b.sortValue(TRANSACAO));

        // 3. Build the query request.
        QueryEnhancedRequest tableQuery = QueryEnhancedRequest.builder()
                .queryConditional(sortGreaterThanOrEqualTo)
                .build();
        // 4. Perform the query.
        PageIterable<Transacao> pagedResults = transacaoTable.query(tableQuery);
        log.info("page count: {}", pagedResults.stream().count()); // Log  number of pages.

        pagedResults.items().stream()
                .sorted()
                .forEach(
                        item -> log.info(item.toString()) // Log the sorted list of items.
                );

        return null;
    }
}
