package miniLotto.experiments;

public class ResultsOfFiveDrawsGlobal extends ResultsOfFiveDraws{

    @Override
    public void add(int result) {
        switch (result) {
            case 0 : results.put("Zero", results.get("Zero") + 1);
                break;
            case 1 : results.put("Jedynka", results.get("Jedynka") + 1);
                break;
            case 2 : results.put("Dwójka", results.get("Dwójka") + 1);
                break;
            case 3 : results.put("Trójka", results.get("Trójka") + 1);
                break;
            case 4 : results.put("Czwórka", results.get("Czwórka") + 1);
                break;
            case 5 : results.put("Piątka", results.get("Piątka") + 1);
                break;
        }
    }
}
