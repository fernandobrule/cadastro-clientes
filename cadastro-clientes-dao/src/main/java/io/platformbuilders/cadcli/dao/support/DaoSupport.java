package io.platformbuilders.cadcli.dao.support;

import io.platformbuilders.cadcli.dao.api.CadastroClientesDaoException;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface DaoSupport {

    default String applySelectItems(final String sqlFragment, final List<String> selectItems,
            final Map<String, String> columnsMap) {
        String select = selectItems //
                .stream() //
                .map(col -> columnsMap.getOrDefault(col, "")) //
                .collect(Collectors.joining(", "));
        return sqlFragment.replaceAll("_select_", selectItems.isEmpty() ? "" : String.format(", %s", select));
    }

    default String applyWhereItems(final String sqlFragment, final List<String> whereItems) {
        String sql = "";
        String where = String.join("and ", whereItems);
        return sqlFragment.replaceAll("_where_", whereItems.isEmpty() ? "" : where);
    }

    default String applyOrderByItems(final String sqlFragment, final List<String> orderByItems,
            final Map<String, String> columnsMap) {
        String orderBy = orderByItems //
                .stream() //
                .map(col -> columnsMap.getOrDefault(col, "")) //
                .collect(Collectors.joining(", "));
        return sqlFragment.replaceAll("_orderBy_", orderByItems.isEmpty() ? "" : String.format("order by %s", orderBy));
    }

    default String applyOrderBy(final String sqlFindPage, final Map<String, String> orderByMap, final String orderBy) {
        return sqlFindPage.replaceAll("_orderBy_", orderByMap.getOrDefault(orderBy, ""));
    }

    default Long getKey(final KeyHolder keyHolder) throws CadastroClientesDaoException {
        Number key = keyHolder.getKey();
        if (key != null) {
            return key.longValue();
        } else {
            throw new CadastroClientesDaoException("cadastro.dao.error.returned.id.is.null");
        }
    }

    default List<String> addAge(final List<String> selectItems) {
        if (!selectItems.contains("age")) {
            selectItems.add("age");
        }

        return selectItems;
    }

}
