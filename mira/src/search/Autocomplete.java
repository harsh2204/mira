package search;

import java.awt.Component;

// Autocomplete - https://stackabuse.com/example-adding-autocomplete-to-jtextfield/
	
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import mira.Conditions;
import sort.Quick;

public class Autocomplete implements DocumentListener{

  private static enum Mode {
    INSERT,
    COMPLETION
  };

  private JTextField textField;
  private final ArrayList<Comparable> keywords;
  private Mode mode = Mode.INSERT;

  public Autocomplete(JTextField textField, ArrayList<Comparable> keywords) {
    this.textField = textField;
    this.keywords = keywords;
    Collections.sort(keywords);
  }

  @Override
  public void changedUpdate(DocumentEvent ev) { }

  @Override
  public void removeUpdate(DocumentEvent ev) { }

  @Override
  public void insertUpdate(DocumentEvent ev) {
    if (ev.getLength() != 1)
      return;

    int pos = ev.getOffset();
    String content = null;
    try {
      content = textField.getText(0, pos + 1);
    } catch (BadLocationException e) {
      e.printStackTrace();
    }

    // Find where the word starts
    int w;
    for (w = pos; w >= 0; w--) {
      if (!Character.isLetter(content.charAt(w))) {
        break;
      }
    }

    // Too few chars
    if (pos - w < 2)
      return;
// The edits made to the file only fit the conditions search. If they work properly
    //we can apply them to the drug names, they need to be tested first.
    String prefix = content.substring(w + 1).toLowerCase();
    Quick.sortBasicQuick(keywords);
    int n = BinarySearch.binarySearch(keywords, prefix);
    if (n < 0 && -n <= keywords.size()) {
      String match = ((Conditions) keywords.get(-n - 1)).getName();
      if (match.startsWith(prefix)) {
        // A completion is found
        String completion = match.substring(pos - w);
        // We cannot modify Document from within notification,
        // so we submit a task that does the change later
        SwingUtilities.invokeLater(new CompletionTask(completion, pos + 1));
      }
    } else {
      // Nothing found
      mode = Mode.INSERT;
    }
  }

  public class CommitAction extends AbstractAction {
    /**
     * 
     */
    private static final long serialVersionUID = 5794543109646743416L;

    @Override
    public void actionPerformed(ActionEvent ev) {
      if (mode == Mode.COMPLETION) {
        int pos = textField.getSelectionEnd();
        StringBuffer sb = new StringBuffer(textField.getText());
        sb.insert(pos, " ");
        textField.setText(sb.toString());
        textField.setCaretPosition(pos + 1);
        mode = Mode.INSERT;
      } else {
        textField.replaceSelection("\t");
      }
    }
  }

  private class CompletionTask implements Runnable {
    private String completion;
    private int position;

    CompletionTask(String completion, int position) {
      this.completion = completion;
      this.position = position;
    }

    public void run() {
      StringBuffer sb = new StringBuffer(textField.getText());
      sb.insert(position, completion);
      textField.setText(sb.toString());
      textField.setCaretPosition(position + completion.length());
      textField.moveCaretPosition(position);
      mode = Mode.COMPLETION;
    }
  }

}
