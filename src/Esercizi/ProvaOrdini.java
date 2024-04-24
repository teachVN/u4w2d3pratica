package Esercizi;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProvaOrdini {

    public static void main(String[] args) {
        Prodotto libro1 = new Prodotto(100l, "Il signore degli anelli", "Libri", 101);
        Prodotto libro2 = new Prodotto(101L, "Il giorno nero", "Libri", 102);
        Prodotto libro3 = new Prodotto(102L, "Collision", "Libri", 10);
        Prodotto libro4 = new Prodotto(103L, "Marracash", "Libri", 13);
        Prodotto baby1 = new Prodotto(104L, "pannolini", "Baby", 7);
        Prodotto baby2 = new Prodotto(105L, "tutina", "Baby", 15);
        Prodotto baby3 = new Prodotto(106L, "cappello", "Baby", 10);
        Prodotto boys1 = new Prodotto(107L, "scarpe", "Boys", 70);
        Prodotto boys2 = new Prodotto(108L, "felpa", "Boys", 40);
        Prodotto boys3 = new Prodotto(109L, "pantalone", "Boys", 40);

        List<Prodotto> prodotti = List.of(libro1, libro2,libro3,libro4,boys1,boys2,boys3,baby1,baby2,baby3);

        Cliente carlo = new Cliente(1l, "Carlo", 2);
        Cliente roberta = new Cliente(2l, "Roberta", 2);
        Cliente sara = new Cliente(3l, "Sara", 2);

        List<Cliente> clienti = List.of(carlo, roberta, sara);

        Ordine o1 = new Ordine(1000l,"aperto", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 3, 10),
                List.of(libro1, libro2, baby1), carlo);

        Ordine o2 = new Ordine(1001l,"chiuso", LocalDate.of(2021, 1, 10), LocalDate.of(2021, 3, 10),
                List.of(boys1, boys2, baby1), roberta);

        Ordine o3 = new Ordine(1002l,"chiuso", LocalDate.of(2021, 3, 10), LocalDate.of(2021, 3, 20),
                List.of(libro3, libro4, boys3), sara);

        List<Ordine> ordini = List.of(o1, o2, o3);

        //esercizio1
        List<Prodotto> l1 = prodotti.stream().filter(prodotto -> prodotto.getCategoria().equals("Libri") &&
                prodotto.getPrezzo()>100).collect(Collectors.toList());

        l1.forEach(prodotto -> System.out.println(prodotto));

        //esercizio2
        List<Ordine> l2 = ordini.stream().filter(ordine -> ordine.getProdotti().stream().
                anyMatch(prodotto -> prodotto.getCategoria().equals("Baby"))).
                collect(Collectors.toList());

        l2.forEach(ordine -> System.out.println(ordine));


//        List<Ordine> ordiniBaby=ordini.stream()
//                .filter(order -> {
//                    List<Prodotto>prodottiBaby=order.getProdotti().stream().
//                            filter(product -> product.getCategoria()
//                            .equals("baby")).toList();
//                    return !prodottiBaby.isEmpty();
//                }).toList();

    //esercizio3
        List<Prodotto> l3 = prodotti.stream().filter(prodotto -> prodotto.getCategoria().equals("Boys")).
                peek(prodotto -> prodotto.setPrezzo(prodotto.getPrezzo()*0.9)).
                collect(Collectors.toList());

        l3.forEach(prodotto -> System.out.println(prodotto));

        //esercizio4
        List<Prodotto> l4 = ordini.stream().filter(ordine -> ordine.getCliente().getLivello()==2 &&
                ordine.getDataOrdine().isAfter(LocalDate.of(2021,1,31)) &&
                ordine.getDataConsegna().isBefore(LocalDate.of(2021,4,2))).
        flatMap(ordine -> ordine.getProdotti().stream()).collect(Collectors.toList());

        l4.forEach(prodotto -> System.out.println(prodotto));
    }

}
