package subway.Controller;

import java.util.List;
import java.util.Scanner;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.View.InfoMessages;
import subway.View.InputView;
import subway.View.OutputView;
import subway.View.Regex;
import subway.domain.Section;
import subway.domain.SectionInitializer;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class PathFinder {
    public PathFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    private Scanner scanner;
    private InputView inputView;

    public void mainRun() {
        inputView = new InputView(scanner);
        String menuSelect = inputView.readMenu(InfoMessages.MAIN_MENU_SELECTION.getMessage(),
                Regex.MAIN_MENU.getMessage());

        if (menuSelect.equals("1")) {
            pathRun();
        }
    }

    private void pathRun() {
        String menuSelect = inputView.readMenu(InfoMessages.PATH_MENU_SELECTION.getMessage(),
                Regex.PATH_MENU.getMessage());
        if (menuSelect.equals("B")) {
            mainRun();
            return;
        }
        List<String> shortestPath = runPathFinding(menuSelect);
        calculateTimeDistance(shortestPath, menuSelect);
    }

    public List<String> runPathFinding(String menuSelect) {
        String pointFrom;
        String pointTo;
        try {
            pointFrom = inputView.readStation(InfoMessages.REQUEST_POINT_FROM.getMessage());
            pointTo = inputView.readStation(InfoMessages.REQUEST_POINT_TO.getMessage());
        } catch (IllegalArgumentException e) {
            pathRun();
            return null;
        }
        return findPath(menuSelect, pointFrom, pointTo);
    }

    public List<String> findPath(String standard, String pointFrom, String pointTo) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = makeGraph(standard);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(pointFrom, pointTo).getVertexList();
        return shortestPath;
    }

    private WeightedMultigraph<String, DefaultWeightedEdge> makeGraph(String standard) {
        if (standard.equals("1")) {
            WeightedMultigraph<String, DefaultWeightedEdge> graph = drawDistanceGraph();
            return graph;
        }
        if (standard.equals("2")) {
            WeightedMultigraph<String, DefaultWeightedEdge> graph = drawTimeGraph();
            return graph;
        }
        return null;
    }

    public void calculateTimeDistance(List<String> shortestPath, String menuSelect) {
        int totalDistance = 0;
        int totalTime = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            totalDistance += SectionRepository.getDistanceByName(shortestPath.get(i), shortestPath.get(i + 1));
            totalTime += SectionRepository.getTimeByName(shortestPath.get(i), shortestPath.get(i + 1));
        }

        OutputView.printResult(shortestPath, totalTime, totalDistance);
    }

    private static WeightedMultigraph<String, DefaultWeightedEdge> drawDistanceGraph() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (Section section : SectionRepository.sections()) {
            String pointFrom = section.getPoints().get(0);
            String pointTo = section.getPoints().get(1);
            graph.addVertex(section.getPoints().get(0));
            graph.addVertex(section.getPoints().get(1));
            graph.setEdgeWeight(graph.addEdge(pointFrom, pointTo), section.getDistance());
        }
        return graph;
    }

    private static WeightedMultigraph<String, DefaultWeightedEdge> drawTimeGraph() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (Section section : SectionRepository.sections()) {
            String pointFrom = section.getPoints().get(0);
            String pointTo = section.getPoints().get(1);
            graph.addVertex(section.getPoints().get(0));
            graph.addVertex(section.getPoints().get(1));
            graph.setEdgeWeight(graph.addEdge(pointFrom, pointTo), section.getDistance());
        }
        return graph;
    }
}
