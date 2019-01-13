import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author James Wilfong
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        NaturalNumber top = model.top();
        NaturalNumber bottom = model.bottom();
        boolean allowed;

        view.updateBottomDisplay(bottom);
        view.updateTopDisplay(top);

        if (top.compareTo(bottom) < 0) {
            allowed = false;
        } else {
            allowed = true;
        }
        view.updateSubtractAllowed(allowed);

        if (bottom.isZero()) {
            allowed = false;
        } else {
            allowed = true;
        }
        view.updateDivideAllowed(allowed);

        if (bottom.canConvertToInt()) {
            allowed = true;
        } else {
            allowed = false;
        }
        view.updatePowerAllowed(allowed);
        view.updateRootAllowed(allowed);

        if (bottom.compareTo(TWO) >= 0) {
            allowed = true;
        } else {
            allowed = false;
        }
        view.updateRootAllowed(allowed);

    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {

        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        NaturalNumber top = this.model.top();

        /*
         * Update model in response to this event
         */
        top.copyFrom(bottom);

        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddEvent() {

        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        NaturalNumber top = this.model.top();

        /*
         * Update model in response to this event
         */
        bottom.add(top);
        top.clear();

        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processSubtractEvent() {

        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        NaturalNumber top = this.model.top();

        /*
         * Update model in response to this event
         */
        top.subtract(bottom);
        bottom.transferFrom(top);

        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processMultiplyEvent() {

        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        NaturalNumber top = this.model.top();

        /*
         * Update model in response to this event
         */
        bottom.multiply(top);
        top.clear();

        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processDivideEvent() {

        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        NaturalNumber top = this.model.top();

        /*
         * Update model in response to this event
         */
        top.divide(bottom);
        bottom.transferFrom(top);

        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processPowerEvent() {

        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        NaturalNumber top = this.model.top();

        /*
         * Update model in response to this event
         */
        top.power(bottom.toInt());
        bottom.transferFrom(top);

        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processRootEvent() {

        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        NaturalNumber top = this.model.top();

        /*
         * Update model in response to this event
         */
        top.root(bottom.toInt());
        bottom.transferFrom(top);

        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddNewDigitEvent(int digit) {

        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        NaturalNumber temp = new NaturalNumber2(digit);

        /*
         * Update model in response to this event
         */
        String result = bottom.toString() + temp.toString();
        NaturalNumber result1 = new NaturalNumber2(result);
        bottom.transferFrom(result1);

        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

}
