package SM3_stand;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import com.riscure.signalanalysis.Module;
import com.riscure.signalanalysis.Trace;
import com.riscure.signalanalysis.TraceSet;
import com.riscure.signalanalysis.operations.DataOperationException;

public class Correlation extends Module {
    private static final long serialVersionUID = 1L;

    public static final String BIT_GROUP = "bit.group";
    public static final String DATA_LENGTH = "data.length";
    public static final String TRACE_OFFSET = "trace.offset";
    protected JTextField firstTextField, numberTextField, bitGroupTextField;
    protected double[] s, s2, d, d2, sd, dataDeviation, sampleDeviation, sampleDataCorrelation;
    protected int bitGroup;
    protected int traceDataLength;
    protected int dataLength;
    protected boolean memoryReady;

    /** init module */


//    @Override
//    public JPanel initDialog() {
//        //    ButtonGroup trackGroup = new ButtonGroup();
//        JPanel centerPanel = new JPanel();
//        JPanel trackPanel = new JPanel();
//        trackPanel.setBorder(new TitledBorder("Bits"));
//        bitGroupTextField = new JTextField(String.valueOf(bitGroup));
//        bitGroupTextField.setPreferredSize(new Dimension(30, 20));
//        bitGroupTextField.setToolTipText("Number of bits to trace simultaneously");
//        trackPanel.add(bitGroupTextField);
//        javax.swing.JPanel rangePanel = new JPanel();
//        rangePanel.setBorder(new TitledBorder("Range"));
//        rangePanel.add(new JLabel("first: "));
//        firstTextField = new JTextField();
//        firstTextField.setPreferredSize(new Dimension(35, 20));
//        rangePanel.add(firstTextField);
//        rangePanel.add(new JLabel("number: "));
//        numberTextField = new JTextField("");
//        numberTextField.setPreferredSize(new Dimension(40, 20));
//        rangePanel.add(numberTextField);
//        centerPanel.add(trackPanel, BorderLayout.WEST);
//        centerPanel.add(rangePanel, BorderLayout.CENTER);
//        return centerPanel;
//    }
//
//    @Override
//    public void setDialogValues(Trace t, int nt, int sft, int snt, int sfs, int sns) {
//        traceDataLength = (t != null && t.data != null) ? t.data.length * 8 : 0;
//        super.setDialogValues(t, nt, sft, snt, sfs, sns);
//    }
//
//    @Override
//    public void setDialogValues() {
//        traceOffset = getInt(TRACE_OFFSET);
//        bitGroup = getInt(BIT_GROUP);
//        if (traceDataLength != 0 && (traceDataLength < bitGroup || bitGroup < 1))
//            set(BIT_GROUP, bitGroup = 1);
//        if (traceDataLength != 0 && traceDataLength < traceOffset + bitGroup)
//            set(TRACE_OFFSET, traceOffset = 0);
//        dataLength = getInt(DATA_LENGTH);
//        if (traceDataLength != 0 && (dataLength <= 0 || (dataLength + traceOffset) * bitGroup > traceDataLength))
//            set(DATA_LENGTH, dataLength = (traceDataLength / bitGroup) - traceOffset);
//        setInt(firstTextField, TRACE_OFFSET);
//        setInt(bitGroupTextField, BIT_GROUP);
//        setInt(numberTextField, DATA_LENGTH);
//    }
//
//    @Override
//    public void getDialogValues() {
//        bitGroup = parseInt(bitGroupTextField, BIT_GROUP);
//        if (bitGroup < 1)
//            bitGroup = 1;
//        traceOffset = parseInt(firstTextField, TRACE_OFFSET);
//        dataLength = parseInt(numberTextField, DATA_LENGTH);
//        if (traceDataLength != 0 && (dataLength <= 0 || (dataLength + traceOffset) * bitGroup > traceDataLength))
//            set(DATA_LENGTH, dataLength = (traceDataLength / bitGroup) - traceOffset);
//    }

    /**
     * Method to get the memory requirements for a specific application
     * 
     * @result long - memory required for result traces
     */
    @Override
    public long getRequiredMemorySize() {
        // s, s2, d, d2 sd
        return 8 * ((2 * numberOfSamples + 2 * dataLength) + ((long) numberOfSamples * dataLength));
    }

    /**
     * Method to initialize the process
     * 
     * @result boolean - whether or not the process can start
     */
    @Override
    public boolean initProcess() {
        if (bitGroup == 1)
            globalTitle = "bit";
        else if (bitGroup == 8)
            globalTitle = "byte";
        else
            globalTitle = "" + bitGroup + "-bit data group";
        yScale = 1;
        yLabel = "";
        memoryReady = false;
        xOffset = firstSampleIndex;
        return true;
    }

    protected boolean initProcess(Trace t) {
        if (t == null || t.getSample() == null || t.getNumberOfSamples() == 0 || t.data == null || t.data.length == 0)
            return false;
        numberOfSamples = t.getNumberOfSamples();
        if (traceDataLength != t.data.length * 8) {
            traceDataLength = t.data.length * 8;
            if (bitGroup > traceDataLength && traceDataLength > 0) {
                bitGroup = traceDataLength;
                set(BIT_GROUP, bitGroup);
            }
            if (traceDataLength != 0 && traceDataLength < traceOffset + bitGroup)
                set(TRACE_OFFSET, traceOffset = 0);
        }
        s = new double[numberOfSamples];
        s2 = new double[numberOfSamples];
        d = new double[dataLength];
        d2 = new double[dataLength];
        sd = new double[numberOfSamples * dataLength];
        dataDeviation = d2; // re-use variable to save memory
        sampleDeviation = s2; // re-use variable to save memory
        sampleDataCorrelation = sd; // re-use variable to save memory
        memoryReady = true;
        sampleCoding = TraceSet.FLOAT_CODING; // No use returning correlation as integer
        return true;
    }

    /**
     * Method for analyzing a single trace
     * 
     * @parameter Trace t - trace to process
     * @result int - index of next requested trace
     */
    @Override
    public int analyze(Trace t) {
        if (!memoryReady && !initProcess(t)) {
            err("ERROR: can not run correlation on this trace set");
            return NO_TRACE;
        }
        float[] data = select(t);
        if (data == null || t.getSample() == null)
            return NO_TRACE;
        for (int i = 0; i < data.length; i++) {
            d[i] += data[i];
            d2[i] += ((double) data[i]) * ((double) data[i]);
        }
        for (int i = 0; i < t.getNumberOfSamples() && !aborted; i++) {
            double f = t.getSample(i);
            s[i] += f;
            s2[i] += f * f;
            for (int j = 0, k = i; j < data.length; j++, k += t.getNumberOfSamples())
                sd[k] += f * data[j];
        }
        numberOfAnalyzedTraces++;
        if (currentTraceIndex < lastTraceIndex && lastTraceIndex != 0)
            return ++currentTraceIndex;
        return (currentTraceIndex = NO_TRACE);
    }

    /**
     * Selection function
     * 
     * @param data - input trace
     * @return selected data bits
     */
    public float[] select(Trace t) {
        return select(t.getData());
    }

    /**
     * Selection function
     * 
     * @param data - input byte array
     * @return selected data bits
     */
    public float[] select(byte[] data) {
        float[] selected = new float[dataLength];
        if (data == null)
            return selected;
        if (bitGroup > 1)
            for (int i = 0; i < dataLength; i++) {
                int bitOffset = (i + traceOffset) * bitGroup;
                for (int j = 0; j < bitGroup; j++)
                    selected[i] += getBit(data, bitOffset + j);

            }
        else
            for (int i = 0; i < dataLength; i++)
                selected[i] = getBit(data, i + traceOffset);

        return selected;
    }

    public int getBit(byte[] in, int offset) {
        if (offset < 0 || offset >= in.length * 8)
            return 0;
        return (in[offset / 8] >> (7 - (offset % 8))) & 1;
    }

    /**
     * Method to retrieve available trace
     * 
     * @result Trace t - Trace resulting from processing
     */
    @Override
    public Trace generate(int index) {
        float[] f = new float[numberOfSamples];
        for (int i = 0, j = index * numberOfSamples; i < numberOfSamples; i++, j++)
            f[i] = (float) sampleDataCorrelation[j];
        return new Trace(null, null, f);
    }

    /**
     * Method to compute results
     * 
     * @throws DataOperationException
     */
    @Override
    public void finishProcess() throws DataOperationException {
        if (numberOfAnalyzedTraces == 0)
            return;
        for (int i = 0; i < numberOfSamples; i++)
            sampleDeviation[i] = Math.sqrt((s2[i] - s[i] * s[i] / numberOfAnalyzedTraces));
        for (int i = 0; i < dataLength; i++) { // complete correlation calculation
            dataDeviation[i] = Math.sqrt((d2[i] - d[i] * d[i] / numberOfAnalyzedTraces));
            for (int j = 0, k = i * numberOfSamples; j < numberOfSamples; k++, j++) {
                if (dataDeviation[i] == 0 || sampleDeviation[j] == 0)
                    sampleDataCorrelation[k] = 0;
                else
                    sampleDataCorrelation[k] = (float) ((sd[k] - s[j] * d[i] / numberOfAnalyzedTraces) / (dataDeviation[i] * sampleDeviation[j]));
            }
        }
        numberOfResultTraces = dataLength;
    }

    public static double computeCorrelation(double[] x, int xOffset, int xStep, double[] y, int yOffset, int yStep,
            int length) {
        double sx = 0;
        double sx2 = 0;
        double sy = 0;
        double sy2 = 0;
        double sxy = 0;
        if (length < 1)
            return 0;
        for (int i = 0, p = xOffset, q = yOffset; i < length; i++, p += xStep, q += yStep) {
            sx += x[p];
            sx2 += x[p] * x[p];
            sy += y[q];
            sy2 += y[q] * y[q];
            sxy += x[p] * y[q];
        }
        double xVar = sx2 - sx * sx / length;
        double yVar = sy2 - sy * sy / length;
        if (xVar == 0 || yVar == 0)
            return 0;
        return (sxy - sx * sy / length) / Math.sqrt(xVar * yVar);
    }

    public static double computeVariance(double[] x, int offset, int length, int step) {
        double sx = 0;
        double sx2 = 0;
        if (length < 1)
            return 0;
        for (int i = 0, j = offset; i < length; i++, j += step) {
            sx += x[j];
            sx2 += x[j] * x[j];
        }
        return (sx2 - sx * sx / length) / (length - 1);
    }
}