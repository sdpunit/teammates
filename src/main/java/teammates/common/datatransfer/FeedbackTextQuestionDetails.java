package teammates.common.datatransfer;

import teammates.common.util.Const;
import teammates.common.util.FeedbackQuestionFormTemplates;
import teammates.common.util.Sanitizer;

public class FeedbackTextQuestionDetails extends
		FeedbackAbstractQuestionDetails {
	public FeedbackTextQuestionDetails() {
		super(FeedbackQuestionType.TEXT);
	}
	
	public FeedbackTextQuestionDetails(String questionText) {
		super(FeedbackQuestionType.TEXT, questionText);
	}

	@Override
	public String getQuestionTypeDisplayName() {
		return Const.FeedbackQuestionTypeNames.TEXT;
	}
	
	@Override
	public boolean isChangesRequiresResponseDeletion(FeedbackAbstractQuestionDetails newDetails) {
		return false;
	}

	@Override
	public String getQuestionWithExistingResponseSubmissionFormHtml(boolean sessionIsOpen, int qnIdx,
			int responseIdx, FeedbackAbstractResponseDetails existingResponseDetails,
			FeedbackAbstractQuestionDetails questionDetails) {
		return FeedbackQuestionFormTemplates.populateTemplate(
				FeedbackQuestionFormTemplates.TEXT_SUBMISSION_FORM,
				"${disabled}", sessionIsOpen ? "" : "disabled=\"disabled\"",
				"${Const.ParamsNames.FEEDBACK_RESPONSE_TEXT}", Const.ParamsNames.FEEDBACK_RESPONSE_TEXT,
				"${qnIdx}", Integer.toString(qnIdx),
				"${responseIdx}", Integer.toString(responseIdx),
				"${existingResponse}", Sanitizer.sanitizeForHtml(existingResponseDetails.getAnswerString()));
	}

	@Override
	public String getQuestionWithoutExistingResponseSubmissionFormHtml(
			boolean sessionIsOpen, int qnIdx, int responseIdx,
			FeedbackAbstractQuestionDetails questionDetails) {
		return FeedbackQuestionFormTemplates.populateTemplate(
				FeedbackQuestionFormTemplates.TEXT_SUBMISSION_FORM,
				"${disabled}", sessionIsOpen ? "" : "disabled=\"disabled\"",
				"${Const.ParamsNames.FEEDBACK_RESPONSE_TEXT}", Const.ParamsNames.FEEDBACK_RESPONSE_TEXT,
				"${qnIdx}", Integer.toString(qnIdx),
				"${responseIdx}", Integer.toString(responseIdx),
				"${existingResponse}", "");
	}

	@Override
	public String getQuestionSpecificEditFormHtml(int questionNumber) {
		return "";
	}
}
