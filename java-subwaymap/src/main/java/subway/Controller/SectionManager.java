package subway.Controller;

import subway.InfoMessages;
import subway.InputRegex;
import subway.RequestMessages;
import subway.View.InputView;
import subway.domain.LineRepository;
import subway.domain.Validator;

public class SectionManager {
    public static void run() {
        final String featureSelection;
        InfoMessages.SECTION_MANAGEMENT.println();
        featureSelection = InputView.readFeature(InputRegex.SECTION_MANAGEMENT.getRegex());

        if (featureSelection.equals("1")) {
            registerSection();
            run();
            return;
        }
        if (featureSelection.equals("2")) {
            deleteSection();
            run();
        }
    }

    private static void registerSection() {

        String lineName = InputView.readRegistrationLine();
        String stationName = InputView.readRegistrationStation();
        String order = InputView.read(RequestMessages.SECTION_REGISTRATION_ORDER.getMessage());
        if (Integer.parseInt(order) > LineRepository.getLineByName(lineName).getStations().size()){
            registerSection();
            return ;
        }

        try {
            Validator.isInRegex(order, InputRegex.ORDER_NAME.getRegex(), InfoMessages.ERROR_STATION_LINE_REPETITION.getMessage());
        } catch (IllegalArgumentException e) {
            registerSection();
            return ;
        }
        LineRepository.getLineByName(lineName).getStations().add(Integer.parseInt(order),stationName);
    }

    public static void deleteSection() {
        String lineName = InputView.read(RequestMessages.DELETION_LINE.getMessage());
        String stationName = InputView.read("역이름을 입력하세요.");


        LineRepository.deleteSectionByName(lineName, stationName);
    }
}
